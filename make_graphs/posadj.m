function posadj = posadj(posz)

switch posz
    case 1
        posadj = [2,4];
    case 2
        posadj = [1,3,5];
    case 3
        posadj = [2,6];
    case 4
        posadj = [1,5,7];
    case 5
        posadj = [2,4,6,8];
    case 6
        posadj = [3,5,9];
    case 7
        posadj = [4,8];
    case 8
        posadj = [5,7,9];
    case 9
        posadj = [6,8];
end