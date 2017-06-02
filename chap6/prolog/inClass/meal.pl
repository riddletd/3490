%
% playing in prolog
%

% meal planning
calories(branola, 1, 105).
calories(capncrunch, 1, 230).
calories(milkFF, 4, 0).
calories(milkW, 4, 90).
sugar(branola, 1, 2).
sugar(capncrunch, 1, 19).
lowcal_breakfast(X,Y) :- calories(X,_,C1), calories(Y,_,C2), 
                         TotC is C1+C2, TotC < 200.
