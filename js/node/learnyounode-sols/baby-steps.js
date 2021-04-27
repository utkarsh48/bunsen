let arr = process.argv;
sum=0;
for(let i =2;i<arr.length; i++){
    sum+=parseInt(arr[i]);
}
console.log(sum);