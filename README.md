# algorithms.clj
Common algorithms, implemented in Clojure

## Algorithms for vectors

### `windowed`

`(windowed v n)` returns a sliding window with size n, on the vector v.

Example:

```clojure
(windowed 2 [1 2 3]) ;; => '([1 2] [2 3])
```

### `intervals`

`(intervals v)` returns a vector that contains every possible intervals of v.

Example:

```clojure
(intervals [1 2 3]) ;; => '([1] [1 2] [1 2 3] [2] [2 3] [3])
```

## Algorithms for solving math-related problems

### `$=`

`($= & expr)` converts expr to a Lisp sexp (with support for order of operations).

Example:

```clojure
($= 5 + 5 * 5) ;; => 30
(macroexpand '($= 5 + 5 * 5)) ;; => (+ (* 5 5) 5)
```

Coming soon...
