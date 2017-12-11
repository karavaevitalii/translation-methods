#ifndef LEXER_H
#define LEXER_H

#include <string_view>

#include "token.h"

class lexer
{
    char const* cur;
    char const* end;
    token_t token;

public:
    lexer(char const*, char const*);

    void next();
    token_t cur_token() const noexcept;
};

#endif // LEXER_H