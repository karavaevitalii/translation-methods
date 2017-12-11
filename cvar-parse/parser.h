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

    friend std::ofstream& operator<<(std::ofstream&, tree_node const&);
};

std::ofstream& operator<<(std::ofstream&, tree_node const&);

class tree
{
    tree_node root;

    std::string to_string() const;

    friend std::ofstream& operator<<(std::ofstream&, tree const&);

public:
    tree(tree_node);
};

std::ofstream& operator<<(std::ofstream&, tree const&);

class parser
{
    lexer lex;
//TODO: add parse_ampersand
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