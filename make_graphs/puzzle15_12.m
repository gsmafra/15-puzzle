clear all;
clc;
v = (0:(16*16*16 - 1))';
vx(:,1) = floor(v/(16*16))+1;
vx(:,2) = mod(floor(v/16),16)+1;
vx(:,3) = mod(v,16)+1;

vx = vx(vx(:,1) ~= vx(:,2),:);
vx = vx(vx(:,1) ~= vx(:,3),:);
vx = vx(vx(:,2) ~= vx(:,3),:);

prox = zeros(3360,1);
prox(1:14) = 1:14;
currLevelIndex = 1:14;

while ~isempty(currLevelIndex)
    proxK = prox;
    for i = 1:length(currLevelIndex)
        
        currState = vx(currLevelIndex(i),:);
        pos1 = currState(1);
        pos2 = currState(2);
        posz = currState(3);
        adj = posadj15(posz);
        
        for j = 1:length(adj)
            
            if(adj(j) == pos1)
                adjVec = [posz, pos2, adj(j)];
            elseif(adj(j) == pos2)
                adjVec = [pos1, posz, adj(j)];
            else
                adjVec = [pos1, pos2, adj(j)];
            end
            
            iList1 = find(vx(:,1) == adjVec(1));
            iList2 = find(vx(:,2) == adjVec(2));
            iListZ = find(vx(:,3) == adjVec(3));
            index = intersect(intersect(iList1, iList2), iListZ);
            if(prox(index) == 0)
                proxK(index) = currLevelIndex(i);
            end
        end
    end
    diffProx = proxK - prox;
    prox = proxK;
    currLevelIndex = find(diffProx);
end