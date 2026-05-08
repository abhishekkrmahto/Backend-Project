from pydantic import BaseModel # for authentication of data input

class SignupSchema(BaseModel):
     fullname:str
     phone:str
     email:str
     password:str
     
class SigninSchema(BaseModel):
    email:str
    password:str