#ifndef TOKEN_N
#define TOKEN_H

#include <string>
#include <ostream>

enum class token_t
{
    id,
    star,
    ampersand,
    comma,
    semicolon,
    end
};

std::string to_string(token_t const);

std::ostream& operator<<(std::ostream&, token_t const);

#endif //TOKEN_H