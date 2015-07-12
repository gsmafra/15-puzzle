clear all;
clc;
v = (0:(16^4 - 1))';

vx(:,1) = floor(v/(16^3))+1;
vx(:,2) = mod(floor(v/(16^2)), 16)+1;
vx(:,3) = mod(floor(v/(16^1)), 16)+1;
vx(:,4) = mod(v,16)+1;

vx = vx(vx(:,1) ~= vx(:,2),:);
vx = vx(vx(:,1) ~= vx(:,3),:);
vx = vx(vx(:,1) ~= vx(:,4),:);
vx = vx(vx(:,2) ~= vx(:,3),:);
vx = vx(vx(:,2) ~= vx(:,4),:);
vx = vx(vx(:,3) ~= vx(:,4),:);

inter12 = intersect(find(vx(:,1)~=1), find(vx(:,2)~=1));
inter123 = intersect(inter12, find(vx(:,3)~=1));
inter1234 = intersect(inter123, find(vx(:,4)~=1));
vx = vx(inter1234,:);

inter12 = intersect(find(vx(:,1)~=2), find(vx(:,2)~=2));
inter123 = intersect(inter12, find(vx(:,3)~=2));
inter1234 = intersect(inter123, find(vx(:,4)~=2));
vx = vx(inter1234,:);

inter12 = intersect(find(vx(:,1)~=3), find(vx(:,2)~=3));
inter123 = intersect(inter12, find(vx(:,3)~=3));
inter1234 = intersect(inter123, find(vx(:,4)~=3));
vx = vx(inter1234,:);

inter12 = intersect(find(vx(:,1)~=4), find(vx(:,2)~=4));
inter123 = intersect(inter12, find(vx(:,3)~=4));
inter1234 = intersect(inter123, find(vx(:,4)~=4));
vx = vx(inter1234,:);

prox = zeros(11880,1);
prox(325:333) = 325:333;
currLevelIndex = 325:333;

tic;
while ~isempty(currLevelIndex)
    proxK = prox;
    for i = 1:length(currLevelIndex)
        
        currState = vx(currLevelIndex(i),:);
        pos5 = currState(1);
        pos9 = currState(2);
        pos13 = currState(3);
        posz = currState(4);
        adj = posadj15(posz);
        
        for j = 1:length(adj)
            
            if(adj(j) == pos5)
                adjVec = [posz, pos9, pos13, adj(j)];
            elseif(adj(j) == pos9)
                adjVec = [pos5, posz, pos13, adj(j)];
            elseif(adj(j) == pos13)
                adjVec = [pos5, pos9, posz,  adj(j)];
            else
                adjVec = [pos5, pos9, pos13, adj(j)];
            end
            
            iList5  = find(vx(:,1) == adjVec(1));
            iList9  = find(vx(:,2) == adjVec(2));
            iList13 = find(vx(:,3) == adjVec(3));
            iListZ  = find(vx(:,4) == adjVec(4));
            index = intersect(intersect(iList5, iList9), iListZ);
            index = intersect(index, iList13);
            if(prox(index) == 0)
                proxK(index) = currLevelIndex(i);
            end
        end
    end
    diffProx = proxK - prox;
    prox = proxK;
    currLevelIndex = find(diffProx);
end
toc;