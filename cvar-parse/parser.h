#ifndef PARSER_H
#define PARSER_H

#include <string_view>
#include <vector>
#include <memory>
#include <ostream>
#include <string>

#include "lexer.h"

struct tree_node
{
    std::string name;
    std::vector<tree_node> children;

    tree_node(std::string);
    tree_node(std::string, std::vector<tree_node>);

    std::string to_string() const;
    void print(std::ostream&, size_t const depth = 0) const;

    friend std::ostream& operator<<(std::ostream&, tree_node const&);
};

std::ostream& operator<<(std::ostream&, tree_node const&);

class tree
{
    tree_node root;

    friend std::ostream& operator<<(std::ostream&, tree const&);

public:
    explicit tree(tree_node);
};

std::ostream& operator<<(std::ostream&, tree const&);

class parser
{
    lexer lex;

    tree_node parse_declaration_list();
    tree_node parse_rest_declarations();
    tree_node parse_single_declaration();
    tree_node parse_typename();
    tree_node parse_var_list();
    tree_node parse_rest_vars();
    tree_node parse_ampersand();
    tree_node parse_var();
    tree_node parse_star();
    tree_node parse_varname();

    tree_node skip_token(token_t);

public:
    parser(std::string_view);

    tree operator()();
};

#endif //PARSER_H