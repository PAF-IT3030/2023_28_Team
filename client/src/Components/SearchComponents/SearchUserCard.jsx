import React from 'react'
//Update
const SearchUserCard = () => {
  return (
    <div className='py-2 cursor-pointer'>
        <div className='flex items-center'>
              <img className='w-10 h-10 rounded-full' src='https://cdn.pixabay.com/photo/2023/03/31/14/52/rice-field-7890204__340.jpg' alt='' />
              <div className='ml-3'> 
                  <p>Full name</p>
                  <p className='opacity-70'>username</p>
              </div>
        </div>
    </div>
  )
}

export default SearchUserCard