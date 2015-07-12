function NEXT = puzzleiter(NEXT, index, P)

state = P(index,1:9);

[~,posz] = min(state);

posa = posadj(posz);

adjst = adjstate(state, posz, posa);

ST = 10^8*adjst(:,1);
for i=2:9
    ST = ST + 10^(9-i)*adjst(:,i);
end
prox = zeros(1, length(posa));
for i=1:length(posa)
    prox(i) = find(P(:,10)==ST(i));
    if NEXT(prox(i)) == 0
        NEXT(prox(i)) = index;
    end
end
