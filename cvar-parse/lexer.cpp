#include "lexer.h"

#include <stdexcept>
#include <sstream>

namespace
{
    bool is_whitespace(char c)
    {
        return c <= ' ';
    }

    bool is_identifier_start(char c)
    {
        return (c >= 'a' && c <= 'z') ||
               (c >= 'A' && c <= 'Z') ||
                c == '_';
    }

    bool is_identifier_trail(char c)
    {
        return is_identifier_start(c) ||
               (c >= '0' && c <= '9');
    }

    void skip_newline(char const*& c)
    {
        while (*c == '\n')
            ++c;
    }
} //namespace

lexer::lexer(char const * start, char const* end)
    : cur{start},
      end{end}
{
    next();
}

void lexer::next()
{
    skip_newline(cur);
    if (cur == end)
    {
        token = token_t::end;
        return;
    }

    while (is_whitespace(*cur))
        ++cur;

    switch (*cur)
    {
    case '*':
        token = token_t::star;
        ++cur;
        break;
    case '&':
        token = token_t::ampersand;
        ++cur;
        break;
    case ',':
        token = token_t::comma;
        ++cur;
        break;
    case ';':
        token = token_t::semicolon;
        ++cur;
        break;
    default:
        if (is_identifier_start(*cur))
        {
            ++cur;
            while (is_identifier_trail(*cur))
                ++cur;

            token = token_t::id;
        }
        else
        {
            std::stringstream ss;
            ss << "unknown token: " << *cur;
            throw std::runtime_error{ss.str()};
        }
    }
}

token_t lexer::cur_token() const noexcept
{
    return token;
}