cmake_minimum_required(VERSION 3.8)

project(cvar-parse)

set(CMAKE_CXX_STANDART 17)
set(CMAKE_CXX_FLAGS "-std=c++1z")

set(CMAKE_CXX_FLAGS_DEBUG "-Wall -Wextra -W -Wconversion \
        -Wunreachable-code -Winline -pedantic-errors -fsanitize=address,undefined -g")

set(CMAKE_CXX_FLAGS_RELEASE "-O2")

add_executable(parser
    "main.cpp"
    "parser.cpp"            "parser.h"
    "token.cpp"             "token.h"
    "lexer.cpp"             "lexer.h"
    "parser_exception.cpp"  "parser_exception.h")
