function adj = adjstate(state, posz, posa)

adj = zeros(length(posa), 9);

for i = 1:length(posa)
    adj(i,:) = swap(state, posz, posa(i));
end