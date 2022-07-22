(def precedence {'+ 3                 
                 '- 3
                 '/ 2
                 '* 2
                 '** 1})

(defmacro $=
  "A macro for converting infix expressions to Lisp sexps."
  [& expr]
  (-> (list '-> (first expr))
      (concat (sort-by (comp precedence first)
                       (partition 2 (rest expr))))))

(defn **
  "Returns aᵇ."
  [a b]
  (Math/pow a b))

(defn sum
  "Returns ∑ₓ₌ₐᵇ f(x)."
  [a b f]
  (apply + (map f (range a (inc b)))))

(defn prod
  "Returns ∏ₓ₌ₐᵇ f(x)."
  [a b f]
  (apply * (map f (range a (inc b)))))

(def !
  "Returns n!."
  (memoize 
   (fn [n]
     (if (zero? n)
       1
       (*' (! (dec n)) n)))))

(defn integrate
  "Returns ∫ₐᵇ f(x) x*dx with the specified precision."
  [a b f x prec]
  (let [columns (** 10 prec)]
    (* (/ (sum a (* b columns) #(f (* % (/ 1 columns)))) columns) x)))

(defn root
  "Returns the nth √ of x."
  [n x]
  (** x (/ 1 n)))

(def sqrt
  "Returns √(n)"
  (partial root 2))
