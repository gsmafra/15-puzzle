function y = swap(x, pos1, pos2)

temp = x(pos1);
x(pos1) = x(pos2);
x(pos2) = temp;

y = x;