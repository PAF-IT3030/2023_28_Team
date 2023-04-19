import React from 'react'
import StoryViewer from '../../Components/StoryComponents/StoryViewer'

const Story = () => {

    const story = [
        {
            image: "https://cdn.pixabay.com/photo/2023/04/06/19/11/flower-7904985_640.jpg"
        }, {
            image: "https://cdn.pixabay.com/photo/2023/03/29/19/01/fern-7886160_640.jpg"
        }, {
            image: "https://cdn.pixabay.com/photo/2023/04/05/15/39/animal-7901753__340.jpg"
        }, {
            image: "https://cdn.pixabay.com/photo/2022/10/24/14/21/puppy-7543571__340.jpg"
        }
    ]
  return (
    <div>
        <StoryViewer stories={story} />
    </div>
  )
}

export default Story