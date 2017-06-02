
// When running from within a file, you must put code in a Module

// v1 (hello.fs): sring prints when the file is loaded
// v2 (hello_2.fs): string prints when the function is called
// v3 (hello_3.fs): calls the function when the file is loaded
//                  can use fsharpc instead of fsharpi
// v4 (hello_4.fs): calls the function from another function (i.e., test)

module Apr12

   let message text = printfn "%s" text

   let test () =
       printfn "Testing message..."
       message "Hidey Ho!"
