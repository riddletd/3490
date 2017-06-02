foot([Item], Item).
foot([Head|Tail], LastItem) :- foot(Tail, LastItem).

    
