import dotenv from "dotenv";
import mongoose from "mongoose";

dotenv.config();

let db;

export async function connectDB() {
    if (!db) {
        db = await mongoose.connect(process.env.DBURL);
        console.log("MongoDB Connected");
    }
    return db;
}