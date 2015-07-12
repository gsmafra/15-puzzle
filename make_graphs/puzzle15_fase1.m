clear all;
clc;
v = (0:(16^5 - 1))';

vx(:,1) = floor(v/(16^4))+1;
vx(:,2) = mod(floor(v/(16^3)), 16)+1;
vx(:,3) = mod(floor(v/(16^2)), 16)+1;
vx(:,4) = mod(floor(v/(16^1)), 16)+1;
vx(:,5) = mod(v,16)+1;

vx = vx(vx(:,1) ~= vx(:,2),:);
vx = vx(vx(:,1) ~= vx(:,3),:);
vx = vx(vx(:,1) ~= vx(:,4),:);
vx = vx(vx(:,1) ~= vx(:,5),:);
vx = vx(vx(:,2) ~= vx(:,3),:);
vx = vx(vx(:,2) ~= vx(:,4),:);
vx = vx(vx(:,2) ~= vx(:,5),:);
vx = vx(vx(:,3) ~= vx(:,4),:);
vx = vx(vx(:,3) ~= vx(:,5),:);
vx = vx(vx(:,4) ~= vx(:,5),:);

key = vx(:,1)*16^4 + vx(:,2)*16^3+ vx(:,3)*16^2+ vx(:,4)*16 + + vx(:,5);
keyVec = zeros(1,113820);
keyVec(key) = 1:524160;

prox = zeros(524160,1);
prox(1:12) = 1:12;
currLevelIndex = 1:12;

tic;
while ~isempty(currLevelIndex)
    proxK = prox;
    for i = 1:length(currLevelIndex)
        
        currState = vx(currLevelIndex(i),:);
        pos1 = currState(1);
        pos2 = currState(2);
        pos3 = currState(3);
        pos4 = currState(4);
        posz = currState(5);
        adj = posadj15(posz);
        
        for j = 1:length(adj)
            
            if(adj(j) == pos1)
                adjVec = [posz, pos2, pos3, pos4, adj(j)];
            elseif(adj(j) == pos2)
                adjVec = [pos1, posz, pos3, pos4, adj(j)];
            elseif(adj(j) == pos3)
                adjVec = [pos1, pos2, posz, pos4, adj(j)];
            elseif(adj(j) == pos4)
                adjVec = [pos1, pos2, pos3, posz, adj(j)];
            else
                adjVec = [pos1, pos2, pos3, pos4, adj(j)];
            end
            
            key = adjVec(1)*16^4+adjVec(2)*16^3+adjVec(3)*16^2+adjVec(4)*16+adjVec(5);
            index = keyVec(key);
            
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