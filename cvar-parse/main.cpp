#include <iostream>

#include "parser.h"

int main()
{
    std::string s{"e_t ****e, &a, *c, d;"
                  "int a, b, c;"};

    parser p{s};
    auto t = p();

    return EXIT_SUCCESS;
}