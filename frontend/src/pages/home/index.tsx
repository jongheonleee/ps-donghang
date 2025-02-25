import Header from "componennts/Header";
import Footer from "componennts/Footer";
import PostList from "componennts/PostList";
import Carousel from "componennts/Carousel";

export default function Home() {
    return (
        <>
            <Header />
            <Carousel />
            <PostList />
            <Footer />
        </>
    );
}
