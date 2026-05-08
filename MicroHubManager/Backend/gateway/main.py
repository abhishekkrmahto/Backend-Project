from fastapi import FastAPI
from fastapi.middleware.cors import CORSMiddleware
<<<<<<< HEAD
=======
from Controllers.init import *
>>>>>>> 710dfec (added MVC artitechture !!)

app = FastAPI() # instance of fastAPI 

origins = ["https://localhost:5173"]

<<<<<<< HEAD
@app.get("/")
def home():
    return {
=======
app.add_middleware(
    CORSMiddleware,
    allow_origins=origins,
    allow_credentials=True,
    allow_methods=["*"],
    allow_headers=["*"]
)

app.include_router(AuthenticationRouter)

@app.get("/")
def home():
    return {    
>>>>>>> 710dfec (added MVC artitechture !!)
        "name":"ABHISHEK",
        "roll":4516
    }
    
@app.get("/welcome")
def welcome():
    return "ABHISHEK WELCOMES U 💗,"

