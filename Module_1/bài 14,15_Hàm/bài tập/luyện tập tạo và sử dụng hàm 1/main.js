//bài 1:
function alertMessage() {
    alert('Xin chào!');
}

//bài 2:
function plusNumber(input) {
     input++;
     alert('output: '+ input);     
}

//bài 3
function mathNumbers() {
    let a = parseInt(prompt('Nhập số a: ')); 
    let b = parseInt(prompt('Nhập số b: ')); 
    if( a > b ) {
        alert('a > b');
    }else {
        let c = a + b;
        alert('Tổng của hai số: '+ c)
    }
}

//bài 4
function addNumbers2() {
    firstNum = 4;
    secondNum = 8;
    result = firstNum + secondNum;
    return result;  
}
function addNumbers() {
    result = 0;
    alert(result);
    result = addNumbers2();
    alert(result);
}

//bài 5
 function checkStar() {
     let str = prompt('Nhập tên ngôi sao: ');
     let check; 
     for( let i = 0; i< ngoisao.length; i++) {
         if( ngoisao[i] !== str) {
            check = true;
         }else {
            alert('Ngôi sao '+str+' có chòm sao là: '+chomsao[i]);
            check = false;
             break;
         }
     }
     if( check ) {
        alert('Không tìm thấy ngôi sao!');
     }
 }