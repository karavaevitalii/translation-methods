#include <iostream>
#include <vector>
#include <fstream>

#include "parser.h"

std::vector<char> read_whole_file(std::string const& filename)
{
    std::vector<char> ret{};

    FILE* f = ::fopen(filename.c_str(), "rb");
    if (!f)
        throw std::runtime_error{"can not open file: " + filename};

    ::fseek(f, 0, SEEK_END);
    ret.resize(static_cast<size_t>(::ftell(f)));
    ::fseek(f, 0, SEEK_SET);

    ::fread(ret.data(), 1, ret.size(), f);

    ::fclose(f);
    return ret;
}

int main(int argc, char* argv[])
{
    try
    {
        if (argc < 2)
        {
            std::cerr << "usage: ./parser <input> <output>" << std::endl;
            return EXIT_SUCCESS;
        }

        std::string filename{argv[1]};
        auto vec = read_whole_file(filename);
        std::string s{vec.data(), vec.size()};

        parser p{s};
        auto t = p();

        if (argc > 2)
        {
            std::ofstream os{argv[2]};
            os << t << std::endl;
        }
        else
            std::cout << t << std::endl;

    }
    catch (std::exception const& e)
    {
        std::cerr << "error: " << e.what() << std::endl;
        return EXIT_FAILURE;
    }

    return EXIT_SUCCESS;
}