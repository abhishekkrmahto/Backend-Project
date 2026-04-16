from fastapi import FastAPI
from fastapi.middleware.cors import CORSMiddleware

app = FastAPI() # instance of fastAPI 

origins = ["https://localhost:5173"]

@app.get("/")
def home():
    return {
        "name":"ABHISHEK",
        "roll":4516
    }
    
@app.get("/welcome")
def welcome():
    return "ABHISHEK WELCOMES U 💗,"

