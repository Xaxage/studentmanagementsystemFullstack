import React from "react";
import Container from "./container";
import {Avatar, Button} from "antd";
import "./Footer.css"

const Footer = (props) => (
    <div className={"footer"}>
        <Container>
            {props.numberOfStudents !== undefined ?
                <Avatar style={{backgroundColor: "#f56a00", marginRight: "5px"}}
                        size={"large"}>{props.numberOfStudents}</Avatar> : null}
            <Button onClick={() => props.handleAddStudentEventClick()} type={"primary"}>Add new student +</Button>
        </Container>
    </div>
)

export default Footer;