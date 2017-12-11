#include "parser.h"

#include <cassert>
#include <sstream>

tree_node::tree_node(std::string name, std::vector<tree_node> children)
    : name{std::move(name)},
      children{std::move(children)}
{}

tree_node::tree_node(std::string name)
    : name{std::move(name)}
{}
//TODO: print node
std::ofstream& operator<<(std::ofstream& os, tree_node const& node)
{

}

tree::tree(tree_node node)
    : root{std::move(node)}
{}

parser::parser(std::string_view s)
    : lex{s.data(), s.data() + s.size()}
{}

tree parser::operator()()
{
    return tree{tree_node{"S", {parse_declaration_list()}}};
}

tree_node parser::skip_token(token_t const token)
{
    assert(lex.cur_token() == token);
    lex.next();
    return tree_node{to_string(token)};
}
//TODO: throw exception instead of assert(false)
tree_node parser::parse_declaration_list()
{
    switch (lex.cur_token())
    {
    case token_t::id:
        return tree_node{"S", {parse_single_declaration(), parse_rest_declarations()}};
    default:
        assert(false);
    }
}

tree_node parser::parse_rest_declarations()
{
    switch (lex.cur_token())
    {
    case token_t::id:
        return tree_node{"S'", {parse_single_declaration(), parse_rest_declarations()}};
    case token_t::end:
        return tree_node{"S'"};
    default:
        assert(false);
    }
}

tree_node parser::parse_single_declaration()
{
    switch (lex.cur_token())
    {
    case token_t::id:
        return tree_node{"D", {parse_typename(), parse_var_list(), skip_token(token_t::semicolon)}};
    default:
        assert(false);
    }
}

tree_node parser::parse_typename()
{
    return tree_node{"T", {skip_token(token_t::id)}};
}

tree_node parser::parse_var_list()
{
    switch (lex.cur_token())
    {
    case token_t::id:
    case token_t::star:
    case token_t::ampersand:
        return {"V", {parse_var(), parse_rest_vars()}};
    default:
        assert(false);
    }
}

tree_node parser::parse_rest_vars()
{
    switch (lex.cur_token())
    {
    case token_t::comma:
        return tree_node{"V'", {skip_token(token_t::comma), parse_var(), parse_rest_vars()}};
    case token_t::semicolon:
        return tree_node{"V'"};
    default:
        assert(false);
    }
}

tree_node parser::parse_var()
{
    switch (lex.cur_token())
    {
    case token_t::ampersand:
        return tree_node{"X", {skip_token(token_t::ampersand), parse_varname()}};
    case token_t::star:
        return tree_node{"X", {skip_token(token_t::star), parse_var()}};
    case token_t::id:
        return tree_node{"X", {parse_varname()}};
    default:
        assert(false);
    }
}

tree_node parser::parse_star()
{
    switch (lex.cur_token())
    {
    case token_t::star:
        return tree_node{"X'", {skip_token(token_t::star), parse_star()}};
    case token_t::id:
        return tree_node{"X'", {parse_varname()}};
    default:
        assert(false);
    }
}

tree_node parser::parse_varname()
{
    return tree_node{"N", {skip_token(token_t::id)}};
}