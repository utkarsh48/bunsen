const express= require('express');
const Joi = require('joi');

const app = express();
app.use(express.json());

const courses = [
    {id: 1, name: 'course1'},
    {id: 2, name: 'course2'},
    {id: 3, name: 'course3'}
]


app.get('/api/courses/:id',(req,res)=>{
    const course = courses.find(c=>c.id===parseInt(req.params.id));
    if(!course) res.status(404).send("Course not found");
    res.send(course);
})





app.post('/api/courses',(req,res)=>{
    const course = {
        id: courses.length+1,
        name: req.body.name
    }
    courses.push(course);
    res.send(course);
});


    
app.put('/api/courses/:id',(req,res)=>{
    const course = courses.find(c=>c.id===parseInt(req.params.id));
    if(!course) res.status(404).send("Course not found");
    
    const schema = {
        name: Joi.string().min(3).required()
    };

    const { error } = Joi.validate(req.body, schema);
    if(error) res.status(400).send(error);

    course.name = req.body.name;
    res.send(course);
})




const port = process.env.port || 3000;
app.listen(port,()=> console.log('listening...'));