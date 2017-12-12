#include "token.h"

std::string to_string(token_t const token)
{
    switch (token)
    {
    case token_t::id:
        return "<identifier>";
    case token_t::star:
        return "<*>";
    case token_t::ampersand:
        return "<&>";
    case token_t::comma:
        return "<,>";
    case token_t::semicolon:
        return "<;>";
    default:
        return "<$>";
    }
}

std::ostream& operator<<(std::ostream& os, token_t const token)
{
    return os << to_string(token);
}