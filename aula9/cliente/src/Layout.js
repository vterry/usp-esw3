import { styled } from "styled-components";
import { Outlet, Link } from "react-router-dom";

const MainDiv = styled.div`
    display: flex;
`

const MainNav = styled.nav`
    ul {
        list-style-type: none;
        padding-left: 48px;
        padding-right: 48px;
    }
    li {
        padding-top: 12px;
    }
    a {
        text-decoration: none;
        color: black;
        padding-left: 5px;
        padding-right: 5px;
    }
    a:hover {
        cursor: pointer;
    }
    background-color: #f1f1f1;
`
const OutletWrapper = styled.main`
    margin: 24px;
`



const LinkEstilizado = (params) => {
    const { to } = params;
    return (
        <li>
            <Link to={to}>{params.children}</Link>
        </li>
    )
} 

function Layout() {
    return (
        <MainDiv>
            <MainNav>
                <ul>
                    <LinkEstilizado to="/">Home</LinkEstilizado>
                    <LinkEstilizado to="/localidades">Localidades</LinkEstilizado>
                    <LinkEstilizado to="/pacotes">Pacotes</LinkEstilizado>
                </ul>
            </MainNav>
            <OutletWrapper>
               <Outlet/> 
            </OutletWrapper>
        </MainDiv>
    )
    
}

export default Layout;