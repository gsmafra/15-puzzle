clear all;
clc;

v = (0:(16*16 - 1))';
vx(:,2) = mod(v,16)+1;
vx(:,1) = floor(v/16)+1;
vx = vx(vx(:,1) ~= vx(:,2),:);
vx = vx(intersect(find(vx(:,1)~=1), find(vx(:,2)~=1)),:);

prox = zeros(210,1);
prox(1:14) = 1:14;
currLevelIndex = 1:14;
while ~isempty(currLevelIndex)
    proxK = prox;
    for i = 1:length(currLevelIndex)
        
        currState = vx(currLevelIndex(i),:);
        posz = currState(2);
        pos1 = currState(1);
        adj = posadj15(posz);
        
        for j = 1:length(adj)
            
            if(adj(j) == pos1)
                adjVec = [posz, adj(j)];
            else
                adjVec = [pos1, adj(j)];
            end
            
            indexList1 = find(vx(:,1) == adjVec(1));
            indexListZ = find(vx(:,2) == adjVec(2));
            
            index = intersect(indexList1, indexListZ);
            if(prox(index) == 0)
                proxK(index) = currLevelIndex(i);
            end
        end
    end
    diffProx = proxK - prox;
    prox = proxK;
    currLevelIndex = find(diffProx);
end