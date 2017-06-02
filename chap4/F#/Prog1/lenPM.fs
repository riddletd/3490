
// comment

(* multi-line
   comment
   *)

let rec len L =
    match L with
    | [] -> 0
    | head::tail -> 1 + (len tail)

printfn "len of 5 element list is %d" (len [1..5])
printfn "len of one element list is %d" (len [1]);;

