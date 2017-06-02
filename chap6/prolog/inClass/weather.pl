%
% playing in prolog
%

% weather
sunny(date(4,12,2016)).
hitemp(date(4,12,2016), 57).
lotemp(date(4,12,2016), 40).
lotemp(date(4,13,2016), 31).
warm(date(M,D,Y)) :- sunny(date(M,D,Y)),
                     lotemp(date(M,D,Y), L), L > 32,
                     hitemp(date(M,D,Y), H), H > 55.
hot(date(M,D,Y)) :- sunny(date(M,D,Y)),
                    lotemp(date(M,D,Y), L), L > 55,
                    hitemp(date(M,D,Y), H), H > 85.
