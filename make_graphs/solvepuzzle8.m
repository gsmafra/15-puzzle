% matlab

function st = solvepuzzle8(NEXT, ST, st)

while st ~= 46234
    st = NEXT(st);
    ST(st)
end
