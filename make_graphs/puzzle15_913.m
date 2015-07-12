clear all;
clc;
v = (0:(16*16*16 - 1))';
vx(:,1) = floor(v/(16*16))+1;
vx(:,2) = mod(floor(v/16),16)+1;
vx(:,3) = mod(v,16)+1;

vx = vx(vx(:,1) ~= vx(:,2),:);
vx = vx(vx(:,1) ~= vx(:,3),:);
vx = vx(vx(:,2) ~= vx(:,3),:);

inter12 = intersect(find(vx(:,1)~=1), find(vx(:,2)~=1));
inter123 = intersect(inter12, find(vx(:,3)~=1));
vx = vx(inter123,:);

inter12 = intersect(find(vx(:,1)~=2), find(vx(:,2)~=2));
inter123 = intersect(inter12, find(vx(:,3)~=2));
vx = vx(inter123,:);

inter12 = intersect(find(vx(:,1)~=3), find(vx(:,2)~=3));
inter123 = intersect(inter12, find(vx(:,3)~=3));
vx = vx(inter123,:);

inter12 = intersect(find(vx(:,1)~=4), find(vx(:,2)~=4));
inter123 = intersect(inter12, find(vx(:,3)~=4));
vx = vx(inter123,:);

inter12 = intersect(find(vx(:,1)~=5), find(vx(:,2)~=5));
inter123 = intersect(inter12, find(vx(:,3)~=5));
vx = vx(inter123,:);

prox = zeros(990,1);
prox(325:333,:) = 325:333;
currLevelIndex = 325:333;

while ~isempty(currLevelIndex)
    proxK = prox;
    for i = 1:length(currLevelIndex)
        
        currState = vx(currLevelIndex(i),:);
        pos09 = currState(1);
        pos13 = currState(2);
        posz = currState(3);
        adj = posadj15(posz);
        
        for j = 1:length(adj)
            
            if(adj(j) == pos09)
                adjVec = [posz, pos13, adj(j)];
            elseif(adj(j) == pos13)
                adjVec = [pos09, posz, adj(j)];
            else
                adjVec = [pos09, pos13, adj(j)];
            end
            
            iList3 = find(vx(:,1) == adjVec(1));
            iList4 = find(vx(:,2) == adjVec(2));
            iListZ = find(vx(:,3) == adjVec(3));
            index = intersect(intersect(iList3, iList4), iListZ);
            if(prox(index) == 0)
                proxK(index) = currLevelIndex(i);
            end
        end
    end
    diffProx = proxK - prox;
    prox = proxK;
    currLevelIndex = find(diffProx);
end