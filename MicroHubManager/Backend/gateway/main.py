from fastapi import FastAPI
from fastapi.middleware.cors import CORSMiddleware
from Controllers.authenticationController import router as authRouter
from Controllers.taskController import router as taskRouter


app = FastAPI()

app.add_middleware(
    CORSMiddleware,
    allow_origins=["http://localhost:5173"],
    allow_credentials=True,
    allow_methods=["*"],
    allow_headers=["*"],
)

app.include_router(authRouter)
app.include_router(taskRouter)

@app.get("/")
def home():
    return {
        "name":"ABHISHEK",
        "roll":4516
    }

@app.get("/welcome")
def welcome():
    return "ABHISHEK WELCOMES U 💗"