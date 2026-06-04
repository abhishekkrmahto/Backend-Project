import express from 'express'
import * as taskService from '../service/taskservice.js'



const router = express.Router();

router.post("/createtask",async(req,res)=>{
    res.json(await taskService.createTask(req.body,req.headers["token"]));
})

export default router;