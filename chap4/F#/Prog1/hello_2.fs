
// When running from within a file, you must put code in a Module

// v1 (hello.fs): sring prints when the file is loaded
// v2 (hello_2.fs): defines a message function

module Apr12

   let message text = printfn "%s" text
