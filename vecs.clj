(defn windowed
  "Returns a sliding window with size n, on v."
  [v n]
  (apply map vector (take n (iterate rest v))))

(defn intervals
  "Returns a vector that contains every possible intervals of v."
  [v]
  (for [a (range (count v))
        b (range a (count v))]
    (subvec v a (inc b))))
