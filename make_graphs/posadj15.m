% matlab

function posadj = posadj15(posz)

switch posz
    case 1
        posadj = [2,5];
    case 2
        posadj = [1,3,6];
    case 3
        posadj = [2,4,7];
    case 4
        posadj = [3,8];
    case 5
        posadj = [1,6,9];
    case 6
        posadj = [2,5,7,10];
    case 7
        posadj = [3,6,8,11];
    case 8
        posadj = [4,7,12];
    case 9
        posadj = [5,10,13];
    case 10
        posadj = [6,9,11,14];
    case 11
        posadj = [7,10,12,15];
    case 12
        posadj = [8,11,16];
    case 13
        posadj = [9,14];
    case 14
        posadj = [10,13,15];
    case 15
        posadj = [11,14,16];
    case 16
        posadj = [12,15];
end
