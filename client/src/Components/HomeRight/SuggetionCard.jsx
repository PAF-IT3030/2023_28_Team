import React from 'react'

const SuggetionCard = () => {
  return (
    <div className='flex justify-between items-center'>
        <div className='flex items-center'>
              <img className='w-9 h-9 rounded-full' src='https://cdn.pixabay.com/photo/2022/03/12/19/22/biscuit-7064697__340.jpg' alt='' />
              <div className='ml-2'>
                  <p className='text-sm font-semibold'>username</p>
                  <p className='text-sm font-semibold opacity-70'>Follows you</p>
              </div>
          </div>
          <p className='text-blue-700 text-sm font-semibold'>Follow</p>
    </div>
  )
}

export default SuggetionCard