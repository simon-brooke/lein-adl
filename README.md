# lein-adl

A Leiningen plugin to generate Clojure source code from [Application Description
Language](https://github.com/simon-brooke/adl).

[![Clojars Project](https://img.shields.io/clojars/v/lein-adl.svg)](https://clojars.org/lein-adl)

## Usage

Put `[lein-adl "0.1.2"]` into the `:plugins` vector of your
project.clj.

Example usage:

    $ lein adl

or

    $ lein adl [path-to-adl-file]

If a path to an adl file is provided, it takes precedence over the `:adl-file`
configuration parameter, described below. The supplied value should be a file
conforming to the [ADL 1.4.1 DTD](http://www.journeyman.cc/adl/stable/adl/schemas/adl-1.4.1.dtd).

## Configuration

You may add a key `:adl` to your project.clj whose value should be a map with
some or all of the following keys:

* `:adl-file` the filename of the ADL file to generate from (defaults to `[project-name].adl.xml`);
* `:locale` the locale to generate files for (defaults to your default locale;
* `:path` the path under which to generate files (defaults to the current directory, and you should probably not change this);
* `:verbosity` if set to an integer greater than zero, will print additional information about what ADL is doing

## License

Copyright © 2018 Simon Brooke

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
