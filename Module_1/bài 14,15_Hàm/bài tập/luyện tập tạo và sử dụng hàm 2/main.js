//tính bình phương
function binhphuong(n) {
    return n*n
}

//diện tích hình tròn
function dientich(r) {
    return binhphuong(r)*3.14
}

//chu vi hình tròn
function chuvi(r) {
    return (2*r)*3.14
}

//giai thừa
function giaithua(n) {
    let giaiThua = 1;
    for(let i = 1; i <= n; i++){
        giaiThua = giaiThua * i;
    }
    return giaiThua
}

// kiểm tra kiểu dữ liệu số
function checknumber(n) {
    return typeof n ==='number'? true:false
}

//tìm min
function searchMinNumber(a,b,c) {
    let min = a;
    if(b < min) {
        if(b < c) {
            min =b;
        }else { min = c}
    }
    return min;
}

//kiểm tra số nguyên dương
function check_SoNguyen(n){
    return (Number.isInteger(n) && n > 0);//hàm Number.isInteger(value) dùng để kiểm tra số nguyên.
}
//đổi chổ hai số 
function changeIndex(a,b) {
    let i = a; a = b ; b = i;
    return a+', '+b; 
}

//đảo mảng (reverse)
function reverseArr(arr) {
    let outputArr = [];
    for(let i = 1; i <= arr.length; i++) {
        outputArr[i - 1] = arr[arr.length - i];
    }
    return outputArr;
}

//kiểm tra xem ký tự bất kỳ đó có nằm trong mảng
function checkStringtoArr(arr,str) {
    let n = 0;
    let check = false;
    for(let i = 0; i < arr.length; i++) {
        if( arr[i] == str) {
            check = true;
            n++;
        }
    }
    if( check ) {
        return 'có '+n+' ký tự '+str+' trong mảng';
    }else {
         return str+' không thuộc mảng'
    }
}