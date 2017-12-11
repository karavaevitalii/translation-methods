#include "parser.h"

namespace
{
    void print_indent(std::ostream& os, size_t const count)
    {
        os << std::string(count * 4, ' ');
    }
} //namespace

tree_node::tree_node(std::string name, std::vector<tree_node> children)
    : name{std::move(name)},
      children{std::move(children)}
{}

tree_node::tree_node(std::string name)
    : name{std::move(name)}
{}

void tree_node::print(std::ostream& os, size_t const depth) const
{
    print_indent(os, depth);
    os << name << '\n';
    for (auto const& child : children)
        child.print(os, depth + 1);
}

std::ostream& operator<<(std::ostream& os, tree_node const& node)
{
    node.print(os);
    return os;
}

tree::tree(tree_node node)
    : root{std::move(node)}
{}

std::ostream& operator<<(std::ostream& os, tree const& t)
{
    t.root.print(os);
    return os;
}

parser::parser(std::string_view s)
    : lex{s.data(), s.data() + s.size()}
{}

tree parser::operator()()
{
    return tree{tree_node{"S", {parse_declaration_list()}}};
}

tree_node parser::skip_token(token_t const token)
{
    if (lex.cur_token() != token)
        throw std::runtime_error{"unexpected token: " + to_string(token)};

    lex.next();
    return tree_node{to_string(token)};
}

tree_node parser::parse_declaration_list()
{
    switch (lex.cur_token())
    {
    case token_t::id:
        return tree_node{"S", {parse_single_declaration(), parse_rest_declarations()}};
    default:
        throw std::runtime_error{"unexpected token: " + to_string(lex.cur_token())};
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
        throw std::runtime_error{"unexpected token: " + to_string(lex.cur_token())};
    }
}

tree_node parser::parse_single_declaration()
{
    switch (lex.cur_token())
    {
    case token_t::id:
        return tree_node{"D", {parse_typename(), parse_var_list(), skip_token(token_t::semicolon)}};
    default:
        throw std::runtime_error{"unexpected token: " + to_string(lex.cur_token())};
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
        throw std::runtime_error{"unexpected token: " + to_string(lex.cur_token())};
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
        throw std::runtime_error{"unexpected token: " + to_string(lex.cur_token())};
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
        throw std::runtime_error{"unexpected token: " + to_string(lex.cur_token())};
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
        throw std::runtime_error{"unexpected token: " + to_string(lex.cur_token())};
    }
}

tree_node parser::parse_varname()
{
    return tree_node{"N", {skip_token(token_t::id)}};
}