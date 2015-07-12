ord = randperm(8);
puzzle = zeros(3);
puzzle(1,:) = ord(1:3);
puzzle(2,:) = ord(4:6);
puzzle(3,1:2) = ord(7:8);

P = perms(0:8);
ST = 10^8*P(:,1);
for i=2:9
    ST = ST + 10^(9-i)*P(:,i);
end
P(:,10) = ST;
P = sortrows(P, 10);
ST = P(:,10);

index = 46234;
NEXT = zeros(length(ST), 1);
NEXT(index) = index;

NEXT2 = puzzleiter(NEXT, index, P);

indexes = find(NEXT2 - NEXT);
while 1
    tic
    NEXT = NEXT2;
    for i=1:length(indexes)
        NEXT2 = puzzleiter(NEXT2, indexes(i), P);
    end

    indexes = find(NEXT2 - NEXT);
    if isempty(indexes)
        break;
    end
    toc
    length(find(NEXT2))
end
