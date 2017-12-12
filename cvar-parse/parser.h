#ifndef PARSER_H
#define PARSER_H

#include <string_view>
#include <vector>
#include <memory>
#include <ostream>

#include "lexer.h"

class tree
{
    struct tree_node
    {
        std::string name;
        std::vector<tree_node> children;

        tree_node(std::string);
        tree_node(std::string, tree_node);
        tree_node(std::string, std::vector<tree_node>);

        void print(std::ostream&, size_t const depth = 0) const;
        size_t print_impl(std::ostream&, size_t depth = 0) const;

        friend std::ostream& operator<<(std::ostream&, tree_node const&);
    };

    tree_node root;

    friend std::ostream& operator<<(std::ostream&, tree const&);
    friend class parser;

public:
    explicit tree(tree_node);

    void print_tree(std::ostream&) const;
};

std::ostream& operator<<(std::ostream&, tree const&);

class parser
{
    using node = tree::tree_node;

    lexer lex;

    node parse_declaration_list();
    node parse_rest_declarations();
    node parse_single_declaration();
    node parse_typename();
    node parse_var_list();
    node parse_rest_vars();
    node parse_ampersand();
    node parse_var();
    node parse_star();
    node parse_varname();

    node skip_token(token_t);

public:
    parser(std::string_view);

    tree operator()();
};

#endif //PARSER_H