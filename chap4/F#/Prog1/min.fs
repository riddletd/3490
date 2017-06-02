//
// functional languages make generics easier!
//

module GenericsPlay

  let min a b = if a <= b then a else b

  printfn "Testing min..."
  printf "min 5 2 ...."
  if (min 5 2) <> 2 then printfn "FAILED" else printfn "passed."
  printf "min 2 5 ...."
  if (min 2 5) <> 2 then printfn "FAILED" else printfn "passed."
  printf "min 5.3 2.7 ...."
  if (min 5.3 2.7) <> 2.7 then printfn "FAILED" else printfn "passed."
  printf "min 2.7 5.3 ...."
  if (min 2.7 5.3) <> 2.7 then printfn "FAILED" else printfn "passed."
  printf "min \"foo\" \"fu\"  ...."
  if (min "foo" "fu") <> "foo" then printfn "FAILED" else printfn "passed."
  printf "min \"fu\" \"foo\"  ...."
  if (min "fu" "foo") <> "foo" then printfn "FAILED" else printfn "passed."

  
