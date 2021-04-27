const http = require('http');//http module

let results = ["","",""];//this will store the data from http.get()
let counter = 0;//to keep a counter for no of httpget's done

//it will iterate when counter is 3 i.e. the 'end' for all
function print(){
    for(let i =0 ;i<3 ; i++){
        console.log(results[i]);
    }
}

//accept index(for process.argv) as parameter
function httpGetter(i){
    //http.get method on the url first encountered, 2+i because 2 values are reserved
    http.get(process.argv[2+i],(res)=>{
        //for converting (res)ponse to string/alternatively toString() method can be used
        res.setEncoding('utf8');
        //event data on the url, callback with recived chunk as parameter
        res.on('data',function (chunk){
            //appending the recived chunk to that element of results corresponding to 'i' of httpGetter function
            results[i]+=chunk;
        });
        //event end, when no more data is read
        //runs every time for each value of 'i' that is for each url
        res.on('end',function (){
            //to keep count
            counter++;
            //when 3 that is when data from all inputs receved
            if(counter===3){
                //print function simply iterating over results array
                print();
            }
        });
    })
}


//inputs are recieved from here
for(let i =0 ; i<3 ; i++){
    //i can be index for results
    httpGetter(i);
}