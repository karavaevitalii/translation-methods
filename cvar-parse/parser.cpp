#include "parser.h"

namespace
{
    void print_indent(std::ostream& os, size_t const count)
    {
        os << std::string(count * 4, ' ');
    }
} //namespace

tree::tree_node::tree_node(std::string name)
    : name{std::move(name)}
{}

tree::tree_node::tree_node(std::string name, tree_node child)
    : name{std::move(name)},
      children{std::move(child)}
{}

tree::tree_node::tree_node(std::string name, std::vector<tree_node> children)
    : name{std::move(name)},
      children{std::move(children)}
{}

void tree::tree_node::print(std::ostream& os, size_t const depth) const
{
    print_indent(os, depth);
    os << name << '\n';
    for (auto const& child : children)
        child.print(os, depth + 1);
}

tree::tree(tree_node n)
    : root{std::move(n)}
{}

size_t tree::tree_node::print_impl(std::ostream&os, size_t depth) const
{
    size_t const n_depth = depth;
    for (auto const& child : children)
    {
        size_t child_depth = ++depth;
        depth = child.print_impl(os, depth);
        os << n_depth << " -> " << child_depth << '\n';
    }
    os << n_depth << ' ' << "[label = \"" << name << "\" ] \n";

    return depth;
}

void tree::print_tree(std::ostream& os) const
{
    os << "digraph G {\n";
    root.print_impl(os);
    os << "}\n";
}

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
    auto n = parse_declaration_list();
    return tree{std::move(n)};
}

tree::tree_node parser::skip_token(token_t const token)
{
    if (lex.cur_token() != token)
        throw std::runtime_error{"unexpected token: " + to_string(token)};

    lex.next();
    return node{to_string(token)};
}

tree::tree_node parser::parse_declaration_list()
{
    switch (lex.cur_token())
    {
    case token_t::id:
    {
        auto decl = parse_single_declaration();
        auto rest = parse_rest_declarations();
        std::vector<node> nodes{std::move(decl), std::move(rest)};

        return node{"S", std::move(nodes)};
    }
    default:
        throw std::runtime_error{"unexpected token: " + to_string(lex.cur_token())};
    }
}

tree::tree_node parser::parse_rest_declarations()
{
    switch (lex.cur_token())
    {
    case token_t::id:
    {
        auto decl = parse_single_declaration();
        auto rest = parse_rest_declarations();
        std::vector<node> nodes{std::move(decl), std::move(rest)};

        return node{"S'", std::move(nodes)};
    }
    case token_t::end:
        return node{"S'"};
    default:
        throw std::runtime_error{"unexpected token: " + to_string(lex.cur_token())};
    }
}

tree::tree_node parser::parse_single_declaration()
{
    switch (lex.cur_token())
    {
    case token_t::id:
    {
        auto type_name  = parse_typename();
        auto var_list   = parse_var_list();
        auto semicolon  = skip_token(token_t::semicolon);
        std::vector<node> nodes{std::move(type_name), std::move(var_list), std::move(semicolon)};

        return node{"D", std::move(nodes)};
    }
    default:
        throw std::runtime_error{"unexpected token: " + to_string(lex.cur_token())};
    }
}

tree::tree_node parser::parse_typename()
{
    auto n = skip_token(token_t::id);

    return node{"T", std::move(n)};
}

tree::tree_node parser::parse_var_list()
{
    switch (lex.cur_token())
    {
    case token_t::id:
    case token_t::star:
    case token_t::ampersand:
    {
        auto var    = parse_var();
        auto vars   = parse_rest_vars();
        std::vector<node> nodes{std::move(var), std::move(vars)};

        return node{"V", std::move(nodes)};
    }
    default:
        throw std::runtime_error{"unexpected token: " + to_string(lex.cur_token())};
    }
}

tree::tree_node parser::parse_rest_vars()
{
    switch (lex.cur_token())
    {
    case token_t::comma:
    {
        auto comma  = skip_token(token_t::comma);
        auto var    = parse_var();
        auto vars   = parse_rest_vars();
        std::vector<node> nodes{std::move(comma), std::move(var), std::move(vars)};


        return node{"V'", std::move(nodes)};
    }
    case token_t::semicolon:
        return node{"V'"};
    default:
        throw std::runtime_error{"unexpected token: " + to_string(lex.cur_token())};
    }
}

tree::tree_node parser::parse_var()
{
    switch (lex.cur_token())
    {
    case token_t::ampersand:
    {
        auto ampersand  = skip_token(token_t::ampersand);
        auto varname    = parse_varname();
        std::vector<node> nodes{std::move(ampersand), std::move(varname)};

        return node{"X", std::move(nodes)};
    }
    case token_t::star:
    {
        auto star   = skip_token(token_t::star);
        auto var    = parse_star();
        std::vector<node> nodes{std::move(star), std::move(var)};

        return node{"X", std::move(nodes)};
    }
    case token_t::id:
    {
        auto varname = parse_varname();

        return node{"X", std::move(varname)};
    }
    default:
        throw std::runtime_error{"unexpected token: " + to_string(lex.cur_token())};
    }
}

tree::tree_node parser::parse_star()
{
    switch (lex.cur_token())
    {
    case token_t::star:
    {
        auto star       = skip_token(token_t::star);
        auto starstar   = parse_star();
        std::vector<node> nodes{std::move(star), std::move(starstar)};

        return node{"X'", std::move(nodes)};
    }
    case token_t::id:
    {
        auto varname = parse_varname();

        return node{"X'", std::move(varname)};
    }
    default:
        throw std::runtime_error{"unexpected token: " + to_string(lex.cur_token())};
    }
}

tree::tree_node parser::parse_varname()
{
    auto n = skip_token(token_t::id);

    return node{"N", std::move(n)};
}