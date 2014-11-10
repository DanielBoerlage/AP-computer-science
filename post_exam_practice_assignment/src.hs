

ans1 = sum $ takeWhile (< 1000) $ filter (\x -> x `mod` 3 == 0 || x `mod` 5 == 0) [1..]


ans2 = sum $ takeWhile (< 4000000) $ filter (even) fibs
    where fibs = 0 : 1 : zipWith (+) fibs (tail fibs)


ans3 = 2 * combo 1 100
    where combo a b
            | b == 2      = 2
            | b == succ a = a * b + combo 1 a
            | otherwise   = a * b + combo (a + 1) b


ans4 = head [a * b * c | c <- [1..], b <- [1..c], a <- [(500000-1000*b) / (1000-b)], a^2 + b^2 == c^2, a+b+c == 1000]
